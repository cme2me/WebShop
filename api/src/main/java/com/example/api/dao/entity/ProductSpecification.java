package com.example.api.dao.entity;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ProductSpecification {
    public Specification<Product> findByNameAndPrice(String name, Double fromPrice, Double toPrice) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (name != null) {
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + name + "%"));
            }
            if (fromPrice != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), fromPrice));
            }
            if (toPrice != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("price"), toPrice));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[]{}));
        };
    }
}
