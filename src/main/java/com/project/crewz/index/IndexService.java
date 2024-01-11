package com.project.crewz.index;

import com.project.crewz.common.db.dto.CategoryDto;
import com.project.crewz.common.db.vo.Category;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class IndexService {
    private final IndexDao indexDao;
    private final ModelMapper modelMapper;

    public CategoryDto add(CategoryDto dto) {
        CategoryDto empty  = null;
        Long nextVal = indexDao.nextVal();
        dto.setNo(nextVal);

        Category category = modelMapper.map(dto, Category.class);

        try {
            int cnt = indexDao.insert(category);
            if (cnt > 0) {
                empty = modelMapper.map(indexDao.select(nextVal), CategoryDto.class);
            }
        } catch(DataAccessException e) {
            System.out.println("CategoryService::add -> " + e.getCause());
        }

        return empty;
    }

    public ArrayList<CategoryDto> getAll() {
        ArrayList<CategoryDto> list = new ArrayList<>();

        try {
            for(Category c : indexDao.selectAll()) {
                list.add(modelMapper.map(c, CategoryDto.class));
            }
        } catch(DataAccessException e) {
            System.out.println("CategoryService::getAll -> " + e.getCause());
        }

        return list;
    }
}
