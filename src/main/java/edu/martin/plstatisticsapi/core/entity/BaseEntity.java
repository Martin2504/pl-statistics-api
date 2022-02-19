package edu.martin.plstatisticsapi.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Data
@MappedSuperclass
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseEntity implements Serializable {

  @Column(name = "s_date_created", nullable = false, updatable = false)
  @CreatedDate
  private Instant createdAt = Instant.now();

  @Column(name = "s_date_last_edited", nullable = false)
  @LastModifiedDate
  private Instant updatedAt = Instant.now();

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(updatable = false, insertable = false)
  private Long id;

}
