package com.project.crewz.local;

import com.project.crewz.common.db.dto.LocalDto;
import com.project.crewz.common.db.vo.Local;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LocalService {
    private final LocalDao localDao;
    private final ModelMapper modelMapper;

    public List<LocalDto> getAllByNo(int min, int max) {
        List<LocalDto> list = new ArrayList<>();

        try {
            for(Local local : localDao.selectAllByNo(min, max)) {
                list.add(modelMapper.map(local, LocalDto.class));
            }
        } catch(DataAccessException e) {
            System.out.println("LocalService::getAllByNo -> " + e.getCause());
        }

        return list;
    }

}
