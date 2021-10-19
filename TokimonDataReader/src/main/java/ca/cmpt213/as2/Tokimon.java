/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.cmpt213.as2;

/**
 * 
 * This class store the characteristics of Tokimon
 */
public class Tokimon {
        String name;
        String from;
        String to;
        String score;
        String comment;
        String extra_comments;
        String teamLead;
        String teamName;

    public Tokimon() {
    }

    public Tokimon(String name, String from, String to, String score, String comment, String extra_comments, String teamLead, String teamName) {
        this.name = name;
        this.from = from;
        this.to = to;
        this.score = score;
        this.comment = comment;
        this.extra_comments = extra_comments;
        this.teamLead = teamLead;
        this.teamName = teamName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getExtra_comments() {
        return extra_comments;
    }

    public void setExtra_comments(String extra_comments) {
        this.extra_comments = extra_comments;
    }

    public String getTeamLead() {
        return teamLead;
    }

    public void setTeamLead(String teamLead) {
        this.teamLead = teamLead;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
        
    public String[] toArrayString()
    {
    return new String[]{"",getFrom(),getTo(),"",getScore(),getComment(),"",getExtra_comments()};
            
    }
    
    

}
