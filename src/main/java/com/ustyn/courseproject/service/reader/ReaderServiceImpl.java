package com.ustyn.courseproject.service.reader;

import com.ustyn.courseproject.document.Ticket;
import com.ustyn.courseproject.document.reader.Reader;
import com.ustyn.courseproject.document.reader.Scientist;
import com.ustyn.courseproject.document.reader.Student;
import com.ustyn.courseproject.repository.ReaderRepository;
import com.ustyn.courseproject.service.ticket.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReaderServiceImpl implements ReaderService {

    private final ReaderRepository readerRepository;
    private final TicketService ticketService;

    @Autowired
    public ReaderServiceImpl(ReaderRepository readerRepository,
                             TicketService ticketService) {
        this.readerRepository = readerRepository;
        this.ticketService = ticketService;
    }

    @Override
    public Reader save(Reader reader) {

        Optional<Reader> existingReaderOpt =  reader.getId() != null ? readerRepository.findById(reader.getId().toString()): Optional.empty();

        if (existingReaderOpt.isPresent()) {
            Reader existingReader = existingReaderOpt.get();

            // Update base fields
            existingReader.setName(reader.getName());
            existingReader.setAddress(reader.getAddress());
            existingReader.setTicketId(reader.getTicketId());
            existingReader.setLastVisitDate(reader.getLastVisitDate());

            // Update subclass-specific fields
            if (reader instanceof Student && existingReader instanceof Student) {
                ((Student) existingReader).setInstitution(((Student) reader).getInstitution());
            } else if (reader instanceof Scientist && existingReader instanceof Scientist) {
                ((Scientist) existingReader).setSpecialty(((Scientist) reader).getSpecialty());
            } else {
                throw new IllegalArgumentException("Unsupported Reader type for update: " + reader.getClass());
            }

            return readerRepository.save(existingReader);
        }
        else {

            Ticket ticket = new Ticket();
            Ticket savedTicket = ticketService.save(ticket);

            reader.setTicketId(savedTicket.getId());

            return readerRepository.save(reader);
        }
    }


    @Override
    public boolean existsByName(String name) {
        return readerRepository.existsByName(name);
    }

    @Override
    public List<Reader> findAll() {
        return readerRepository.findAll();
    }

    @Override
    public Reader findById(String id) {
        return readerRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(String id) {
        readerRepository.deleteById(id);
    }

    @Override
    public void delete(Reader reader) {
        ticketService.deleteById(reader.getTicketId());
        readerRepository.deleteById(reader.getId().toString());
    }
}
