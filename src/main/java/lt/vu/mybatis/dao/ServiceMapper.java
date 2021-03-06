package lt.vu.mybatis.dao;

import lt.vu.mybatis.model.Service;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface ServiceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SERVICE
     *
     * @mbg.generated Thu Mar 11 09:51:07 EET 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SERVICE
     *
     * @mbg.generated Thu Mar 11 09:51:07 EET 2021
     */
    int insert(Service record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SERVICE
     *
     * @mbg.generated Thu Mar 11 09:51:07 EET 2021
     */
    Service selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SERVICE
     *
     * @mbg.generated Thu Mar 11 09:51:07 EET 2021
     */
    List<Service> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SERVICE
     *
     * @mbg.generated Thu Mar 11 09:51:07 EET 2021
     */
    int updateByPrimaryKey(Service record);
}