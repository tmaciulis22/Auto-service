package lt.vu.mybatis.dao;

import lt.vu.mybatis.model.Mechanic;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface MechanicMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MECHANIC
     *
     * @mbg.generated Thu Mar 11 09:51:07 EET 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MECHANIC
     *
     * @mbg.generated Thu Mar 11 09:51:07 EET 2021
     */
    int insert(Mechanic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MECHANIC
     *
     * @mbg.generated Thu Mar 11 09:51:07 EET 2021
     */
    Mechanic selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MECHANIC
     *
     * @mbg.generated Thu Mar 11 09:51:07 EET 2021
     */
    List<Mechanic> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MECHANIC
     *
     * @mbg.generated Thu Mar 11 09:51:07 EET 2021
     */
    int updateByPrimaryKey(Mechanic record);
}