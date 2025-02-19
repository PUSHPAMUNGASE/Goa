package com.example.GoaFestival.Controller;

import java.util.List;

import com.example.GoaFestival.Entity.Comment;
import com.example.GoaFestival.Entity.Festival;
import com.example.GoaFestival.Service.FestivalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/festivals")
@CrossOrigin(origins = "http://localhost:8081")
public class FestivalController {

    @Autowired
    private FestivalService festivalService;

    @GetMapping("/month/{month}")
    public ResponseEntity<List<Festival>> getFestivalsByMonth(@PathVariable String month) {
        List<Festival> festivals = festivalService.getFestivalsByMonth(month);
        return ResponseEntity.ok(festivals);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Festival> getFestivalById(@PathVariable Long id) {
        return festivalService.getFestivalById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Festival> createFestival(@RequestBody Festival festival) {
        Festival createdFestival = festivalService.createFestival(festival);
        return ResponseEntity.ok(createdFestival);
    }

    @PostMapping("/{festivalId}/comments")
    public ResponseEntity<Comment> addComment(
            @PathVariable Long festivalId,
            @RequestBody Comment comment) {
        Comment savedComment = festivalService.addComment(festivalId, comment);
        return ResponseEntity.ok(savedComment);
    }

    @GetMapping("/{festivalId}/comments")
    public ResponseEntity<List<Comment>> getComments(@PathVariable Long festivalId) {
        List<Comment> comments = festivalService.getCommentsByFestivalId(festivalId);
        return ResponseEntity.ok(comments);
    }
}