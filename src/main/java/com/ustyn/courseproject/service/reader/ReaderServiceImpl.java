package com.ustyn.courseproject.service.reader;

import com.ustyn.courseproject.document.Ticket;
import com.ustyn.courseproject.document.reader.Reader;
import com.ustyn.courseproject.document.reader.Scientist;
import com.ustyn.courseproject.document.reader.Student;
import com.ustyn.courseproject.repository.ReaderRepository;
import com.ustyn.courseproject.repository.TicketRepository;
import com.ustyn.courseproject.service.subscription.TicketService;
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

        // Kostyl: delete reader if it already exists (тіпа updating)
        if(reader.getId() != null) {
            delete(reader);
        }

        Ticket ticket = null;
        if(reader.getTicketId() != null) {
            ticket = ticketService.findById(reader.getTicketId());
        }

        if(ticket == null) {
            ticket = new Ticket();
        }

        Ticket savedTicket = ticketService.save(ticket);

        reader.setTicketId(savedTicket.getId());

        if(reader instanceof Student student) {
            return readerRepository.save(student);
        } else if (reader instanceof Scientist scientist) {
            return readerRepository.save(scientist);
        }
        return readerRepository.save(reader);
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
        readerRepository.deleteById(reader.getId());
    }
}
