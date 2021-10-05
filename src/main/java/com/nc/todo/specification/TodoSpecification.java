package com.nc.todo.specification;

import com.nc.todo.entity.Todo;
import com.nc.todo.pojo.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class TodoSpecification implements Specification<Todo> {

    private SearchCriteria criteria;

    public TodoSpecification(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate
            (Root<Todo> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        Expression path;
        if(criteria.getKey().equals("userId")){
            path = root.get("user").get("id");
        }else if(root.get(criteria.getKey()).getJavaType() == String.class){
            path = root.<String>get(criteria.getKey());
        }else{
            path = root.get(criteria.getKey());
        }

        if (criteria.getOperation().equalsIgnoreCase(">")) {
            return builder.greaterThanOrEqualTo( path, criteria.getValue().toString());
        }
        else if (criteria.getOperation().equalsIgnoreCase("<")) {
            return builder.lessThanOrEqualTo( path, criteria.getValue().toString());
        }
        else if (criteria.getOperation().equalsIgnoreCase(":")) {
            if (path.getJavaType() == String.class) {
                return builder.like(path, "%" + criteria.getValue() + "%");
            } else {
                return builder.equal(path, criteria.getValue());
            }
        }
        return null;
    }
}
