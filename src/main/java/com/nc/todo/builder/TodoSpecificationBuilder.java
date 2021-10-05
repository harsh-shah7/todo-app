package com.nc.todo.builder;

import com.nc.todo.entity.Todo;
import com.nc.todo.pojo.SearchCriteria;
import com.nc.todo.specification.TodoSpecification;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TodoSpecificationBuilder {

    private final List<SearchCriteria> params;

    public TodoSpecificationBuilder() {
        params = new ArrayList<SearchCriteria>();
    }

    public TodoSpecificationBuilder with(String key, String operation, Object value) {
        params.add(new SearchCriteria(key, operation, value));
        return this;
    }

    public Specification<Todo> build() {
        if (params.size() == 0) {
            return null;
        }

        List<Specification> specs = params.stream()
                .map(TodoSpecification::new)
                .collect(Collectors.toList());

        Specification result = specs.get(0);

        for (int i = 1; i < params.size(); i++) {
            result = Specification.where(result)
                    .and(specs.get(i));
                    /*.isOrPredicate()
                    ? Specification.where(result)
                    .or(specs.get(i))
                    : Specification.where(result)
                    .and(specs.get(i));*/
        }
        return result;
    }

}
