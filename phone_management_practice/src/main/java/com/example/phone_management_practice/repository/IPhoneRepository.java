package com.example.phone_management_practice.repository;

import com.example.phone_management_practice.model.Phone;
import org.springframework.data.repository.CrudRepository;

public interface IPhoneRepository extends CrudRepository<Phone,Integer> {

}
