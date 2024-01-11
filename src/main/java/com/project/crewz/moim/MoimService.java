package com.project.crewz.moim;

import com.project.crewz.common.db.dto.MoimDto;
import com.project.crewz.common.db.vo.Moim;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MoimService {
    private final MoimDao moimDao;
    private final ModelMapper modelMapper;

    public MoimDto add(MoimDto moimDto) {
        if(moimDto == null) {
            return null;
        }

        MoimDto empty = null;

        try {
            // insert
            Moim moim = modelMapper.map(moimDto, Moim.class);
            int cnt = moimDao.insert(moim);

            // insert 확인
            if(cnt > 0) {
                empty = modelMapper.map(moimDao.select(moim.getNo()), MoimDto.class);
            }
        } catch(DataAccessException e) {
            System.out.println("MoimService::add : " + e.getCause());
        }

        return empty;
    }

    public Long nextVal() {
        Long number = null;

        try {
            number = moimDao.nextVal();
        } catch(DataAccessException e) {
            System.out.println("MoimService::nextVal : " + e.getCause());
        }

        return number;
    }
}
