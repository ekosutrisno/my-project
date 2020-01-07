package com.xsis.xsis.model;

import javax.persistence.*;

import com.xsis.xsis.dto.KeahDto;
import com.xsis.xsis.models.common.CommonEntity;

@SqlResultSetMapping(name = "keahlianMapping", classes = { @ConstructorResult(targetClass = KeahDto.class, columns = {
        @ColumnResult(name = "id", type = Long.class), @ColumnResult(name = "biodata_id", type = Long.class),
        @ColumnResult(name = "skill_name", type = String.class),
        @ColumnResult(name = "skill_level_id", type = Long.class),
        @ColumnResult(name = "isdelete", type = Boolean.class) }) })

// List Keahlian Join Biodata
@NamedNativeQuery(name = "Keahlian.getKeahlianBiodata", query = "select a.id,a.biodata_id,a.skill_name,a.skill_level_id,a.isdelete from x_keahlian a "
        + "join x_biodata b on b.id=a.biodata_id where a.biodata_id=:biodataId and a.isdelete=false and b.isdelete=false", resultSetMapping = "keahlianMapping")

/**
 * Keahlian
 */
@Entity
@Table(name = "x_keahlian")
public class Keahlian extends CommonEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "biodata_id")
    private Long biodataId;

    @Column(name = "notes")
    private String skillName;

    @Column(name = "skill_level_id")
    private Long skillLevelId;

    public Keahlian() {
    }

    public Keahlian(Long id, Long biodataId, String skillName, Long skillLevelId) {
        this.id = id;
        this.biodataId = biodataId;
        this.skillName = skillName;
        this.skillLevelId = skillLevelId;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBiodataId() {
        return this.biodataId;
    }

    public void setBiodataId(Long biodataId) {
        this.biodataId = biodataId;
    }

    public String getSkillName() {
        return this.skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public Long getSkillLevelId() {
        return this.skillLevelId;
    }

    public void setSkillLevelId(Long skillLevelId) {
        this.skillLevelId = skillLevelId;
    }

}