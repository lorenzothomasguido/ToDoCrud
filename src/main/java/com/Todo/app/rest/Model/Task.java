package com.Todo.app.rest.Model;

<<<<<<< HEAD
//import jakarta.persistence.*;
import lombok.*;

import javax.persistence.*;


=======
import lombok.*;

import javax.persistence.*;
>>>>>>> f20b1e4cb721c6cff060426822a22307d615dc02
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;


}
