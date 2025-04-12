package com.example.GoaFestival.Service;

import  com.example.GoaFestival.Entity.*;
import  com.example.GoaFestival.Repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FestivalService {
    @Autowired
    private FestivalRepository festivalRepository;

    @Autowired
    private MonthRepository monthRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Transactional
    public List<Festival> getFestivalsByMonth(String monthName) {
        return festivalRepository.findByMonthName(monthName);
    }

    @Transactional
    public Optional<Festival> getFestivalById(Long id) {
        return festivalRepository.findById(id);
    }
    
    

    @Transactional
    public Festival createFestival(Festival festival) {
        Month month = monthRepository.findByName(festival.getMonth().getName());
        if (month == null) {
            month = monthRepository.save(festival.getMonth());
        }
        festival.setMonth(month);

        if (festival.getFestivalDetail() != null) {
            festival.getFestivalDetail().setFestival(festival);
        }

        return festivalRepository.save(festival);
    }

    @Transactional
    public Comment addComment(Long festivalId, Comment comment) {
        Festival festival = festivalRepository.findById(festivalId)
                .orElseThrow(() -> new RuntimeException("Festival not found"));
        comment.setFestival(festival);
        return commentRepository.save(comment);
    }

    @Transactional
    public List<Comment> getCommentsByFestivalId(Long festivalId) {
        return commentRepository.findByFestivalId(festivalId);
    }
}
