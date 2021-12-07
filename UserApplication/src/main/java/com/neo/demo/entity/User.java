package com.neo.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
@Getter
@Setter
@SQLDelete(sql="UPDATE user SET deleted=true WHERE user_id=?")
@Where(clause = "deleted=false")
public class User {

@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
 private int UserId;
 
@NotBlank(message = "Please enter name")
@Size(min=4, message = "Name should be atleast 4 characters")
 private String firstName;

@NotBlank(message = "Please enter name")
@Size(min=4, message = "Name should be atleast 4 characters")
 private String lastName;

@NotBlank(message = "Please enter Date of Birth")
@JsonFormat(pattern = "dd-mm-yyyy",shape = Shape.STRING)
 private String dateofBirth;

@NotBlank(message = "Please enter Date of Joining")
@JsonFormat(pattern = "dd-mm-yyyy",shape = Shape.STRING)
 private String dateOfJoining;

@Email(message = "Please enter valid email", regexp="^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}")
@NotBlank(message = "Please enter Email")
private String email;

@NotBlank(message = "Please enter Adress")
private String adress;
 
@NotBlank(message = "Please enter Pincode")
@Pattern(regexp = "^([0-9]{4}|[0-9]{6})$")
 private String  pincode;


 private boolean deleted=Boolean.FALSE;
 






	
}
