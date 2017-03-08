package org.redlich.json;

import java.util.Date;

public class Publication {
    private String publication;
    private Date publicationDate;
    private String author;
    private String publicationType;
    private String publisher;

    public Publication() {
        setPublication("publication");
        setPublicationDate(new Date());
        setAuthor("author");
        setPublicationType("type");
        setPublisher("publisher");
        }

    public Publication(String publication,Date publicationDate,String author,String publicationType,String publisher) {
        setPublication(publication);
        setPublicationDate(publicationDate);
        setAuthor(author);
        setPublicationType(publicationType);
        setPublisher(publisher);
        }

    public String getPublication() {
        return publication;
        }

    public void setPublication(String publication) {
        this.publication = publication;
        }

    public Date getPublicationDate() {
        return publicationDate;
        }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
        }

    public String getAuthor() {
        return author;
        }

    public void setAuthor(String author) {
        this.author = author;
        }

    public String getPublicationType() {
        return publicationType;
        }

    public void setPublicationType(String publicationType) {
        this.publicationType = publicationType;
        }

    public String getPublisher() {
        return publisher;
        }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
        }

    @Override
    public String toString() {
        return "Publication{" +
                "publication='" + publication + '\'' +
                ", publicationDate=" + publicationDate +
                ", author='" + author + '\'' +
                ", publicationType='" + publicationType + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
        }
    }
