package lt.vu.mybatis.dao;

import java.util.List;

import lt.vu.mybatis.model.Car;
import org.mybatis.cdi.Mapper;

@Mapper
public interface CarMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.CAR
     *
     * @mbg.generated Wed Mar 10 20:42:44 EET 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.CAR
     *
     * @mbg.generated Wed Mar 10 20:42:44 EET 2021
     */
    int insert(Car record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.CAR
     *
     * @mbg.generated Wed Mar 10 20:42:44 EET 2021
     */
    Car selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.CAR
     *
     * @mbg.generated Wed Mar 10 20:42:44 EET 2021
     */
    List<Car> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.CAR
     *
     * @mbg.generated Wed Mar 10 20:42:44 EET 2021
     */
    int updateByPrimaryKey(Car record);
}