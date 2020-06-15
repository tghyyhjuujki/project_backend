package board.entity;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "store_list")
@NoArgsConstructor
@Data
public class BoardEntity {
	@Id // 엔티티의 PK(기본키)
	@GeneratedValue(strategy = GenerationType.AUTO) // 데이터베이스에서 제공하는 기본키 생성 전략을 따름
	private int boardIdx;

	private String category;
	private String store_name;
	private String store_address;
	private String storeNumber;
	private String store_explanation;
	private String storeImage1;
	private String storeImage2;
	private String storeImage3;
	private String storeImage4;
	private String store_open_time;
	private String store_end_time;
	private String store_coupon;

	// 초기값을 설정 ==> 특정 DB에 의존하지 않도록 하기 위해
	private LocalDateTime createdDatetime = LocalDateTime.now();
	private String CreatorId;
	private String updaterId;

	private LocalDateTime updatedDatetime;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "board_idx")
	private Collection<BoardFileEntity> fileInfoList;
}
