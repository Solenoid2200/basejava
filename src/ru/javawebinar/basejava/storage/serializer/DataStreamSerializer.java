package ru.javawebinar.basejava.storage.serializer;

import ru.javawebinar.basejava.model.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class DataStreamSerializer implements StreamSerializer {

    @Override
    public void doWrite(Resume r, OutputStream os) throws IOException {
        try (DataOutputStream dos = new DataOutputStream ( os )) {
            dos.writeUTF ( r.getUuid ( ) );
            dos.writeUTF ( r.getFullName ( ) );
            Map<ContactType, String> contacts = r.getContacts ( );
            writeCollection ( dos, contacts.entrySet ( ), entry -> {
                dos.writeUTF ( entry.getKey ( ).name ( ) );
                dos.writeUTF ( entry.getValue ( ) );
            } );

            Map<SectionType, Section> sections = r.getSections ( );
            writeCollection ( dos, sections.entrySet ( ), entry -> {
                SectionType type = entry.getKey ( );
                dos.writeUTF ( type.name ( ) );
                Section section = entry.getValue ( );
                switch (type) {
                    case PERSONAL:
                    case OBJECTIVE:
                        dos.writeUTF ( ((TextSection) section).getContent ( ) );
                        break;
                    case ACHIEVEMENT:
                    case QUALIFICATIONS:
                        writeCollection ( dos, ((ListSection) section).getItems ( ), dos::writeUTF );
                        break;
                    case EXPERIENCE:
                    case EDUCATION:
                        writeCollection ( dos, ((OrganizationSection) section).getOrganizations ( ), organization -> {
                            dos.writeUTF ( organization.getHomePage ( ).getName ( ) );
                            dos.writeUTF ( organization.getHomePage ( ).getUrl ( ) );
                            writeCollection ( dos, organization.getPositions ( ), position -> {
                                dos.writeUTF ( position.getStartDate ( ).toString ( ) );
                                dos.writeUTF ( position.getEndDate ( ).toString ( ) );
                                dos.writeUTF ( position.getTitle ( ) );
                                dos.writeUTF ( position.getDescription ( ) );
                            } );
                        } );
                        break;
                }
            } );
        }
    }

    private interface CollectionWriter<T> {
        void write(T t) throws IOException;
    }

    private <T> void writeCollection(DataOutputStream dos,
                                     Collection<T> collection,
                                     CollectionWriter<T> collectionWriter) throws IOException {
        dos.writeInt ( collection.size ( ) );
        for (T t : collection) {
            collectionWriter.write ( t );
        }
    }

    @Override
    public Resume doRead(InputStream is) throws IOException {
        try (DataInputStream dis = new DataInputStream ( is )) {
            String uuid = dis.readUTF ( );
            String fullName = dis.readUTF ( );
            Resume resume = new Resume ( uuid, fullName );
            readCollection ( dis, () -> resume.addContact ( ContactType.valueOf ( dis.readUTF ( ) ), dis.readUTF ( ) ) );

            readCollection ( dis, () -> {
                        SectionType sectionType = SectionType.valueOf ( dis.readUTF ( ) );
                        resume.addSection ( sectionType, readSection ( dis, sectionType ) );
                    }
            );
            return resume;
        }
    }

    private interface CollectionReadable {
        void read() throws IOException;
    }

    private void readCollection(DataInputStream dis, CollectionReadable collectionReadable) throws IOException {
        int size = dis.readInt ( );
        for (int i = 0; i < size; i++) {
            collectionReadable.read ( );
        }
    }

    private Section readSection(DataInputStream dis, SectionType sectionType) throws IOException {
        switch (sectionType) {
            case PERSONAL:
            case OBJECTIVE:
                return new TextSection ( dis.readUTF ( ) );
            case ACHIEVEMENT:
            case QUALIFICATIONS:
                int size = dis.readInt ( );
                List<String> items = new ArrayList<> ( size );
                for (int i = 0; i < size; i++) {
                    items.add ( dis.readUTF ( ) );
                }
                return new ListSection ( items );
            case EXPERIENCE:
            case EDUCATION:
                int size2 = dis.readInt ( );
                List<Organization> organizations = new ArrayList<> ( size2 );
                for (int i = 0; i < size2; i++) {
                    Link link = new Link ( dis.readUTF ( ), dis.readUTF ( ) );
                    int size3 = dis.readInt ( );
                    List<Organization.Position> positions = new ArrayList<> ( size3 );
                    for (int j = 0; j < size3; j++) {
                        Organization.Position position = new Organization.Position (
                                LocalDate.parse ( dis.readUTF ( ) ), LocalDate.parse ( dis.readUTF ( ) ),
                                dis.readUTF ( ), dis.readUTF ( ) );
                        positions.add ( position );
                    }
                    organizations.add ( new Organization ( link, positions ) );
                }
                return new OrganizationSection ( organizations );
            default:
                throw new IllegalStateException ( );
        }
    }

}
