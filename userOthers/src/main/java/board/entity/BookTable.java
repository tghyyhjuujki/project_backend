package board.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book_table")
@NoArgsConstructor
@Data
public class BookTable {
	@Id // 엔티티의 PK(기본키)
	@GeneratedValue(strategy = GenerationType.AUTO) // 데이터베이스에서 제공하는 기본키 생성 전략을 따름
	private int id;
	
	private String book_date;
	private String book_time;
	private String book_num_of_people;
	private String user_name;
	private String booker_phone;
	private String storeNumber;
}
