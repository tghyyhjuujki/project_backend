package board.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "template")
@NoArgsConstructor
@Data
public class TemplateEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String templateName;
	private String templateImage1;
	private String templateImage2;
	private String templateImage3;
	private String templateImage4;
	
}
