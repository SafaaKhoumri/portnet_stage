package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;

    @ManyToOne
    @JoinColumn(name = "niveau_id")
    private Level niveau;

    @ManyToMany
    @JoinTable(name = "question_theme", joinColumns = @JoinColumn(name = "question_id"), inverseJoinColumns = @JoinColumn(name = "theme_id"))
    private List<Theme> themes;

    @OneToMany(mappedBy = "question")
    private List<AnswerChoice> answerChoices;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers;

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Level getNiveau() {
        return niveau;
    }

    public void setNiveau(Level niveau) {
        this.niveau = niveau;
    }

    public List<Theme> getThemes() {
        return themes;
    }

    public void setThemes(List<Theme> themes) {
        this.themes = themes;
    }

    public List<AnswerChoice> getAnswerChoices() {
        return answerChoices;
    }

    public void setAnswerChoices(List<AnswerChoice> answerChoices) {
        this.answerChoices = answerChoices;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Question() {
    }
}
