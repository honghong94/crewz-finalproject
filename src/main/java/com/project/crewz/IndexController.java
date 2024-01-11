package com.project.crewz;

import com.project.crewz.common.db.dto.LocalDto;
import com.project.crewz.index.IndexService;
import com.project.crewz.common.db.dto.CategoryDto;
import com.project.crewz.common.db.dto.MoimDto;
import com.project.crewz.common.db.form.MoimForm;
import com.project.crewz.common.s3.AwsS3;
import com.project.crewz.local.LocalService;
import com.project.crewz.moim.MoimService;
import com.project.crewz.test.Msg;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class IndexController {
    private final IndexService indexService;
    private final LocalService localService;
    private final MoimService moimService;
    private final ModelMapper modelMapper;
    private final AwsS3 awsS3;

    @RequestMapping("/")
    public String home(Model model) {
        List<CategoryDto> list = indexService.getAll();
        model.addAttribute("list", list);

        List<LocalDto> localList = localService.getAllByNo(1, 5);
        model.addAttribute("localList", localList);

        return "index";
    }

    @PostMapping("/moim/add")
    @ResponseBody
    public ResponseEntity<Msg> moimAdd(@ModelAttribute MoimForm form) {
        System.out.println("MoimForm 값");
        System.out.println("photo length: " + form.getPhoto().length);
        System.out.println(form.toString() + "\n");

        MoimDto dto = modelMapper.map(form, MoimDto.class);
        dto.setPhoto1(form.getPhoto()[0].getOriginalFilename());
        dto.setPhoto2(form.getPhoto()[1].getOriginalFilename());
        dto.setPhoto3(form.getPhoto()[2].getOriginalFilename());

        Long number = moimService.nextVal();
        if(number != null && form.getPhoto().length == 3) {
            for(MultipartFile mf : form.getPhoto()) {
                awsS3.upload(mf, "moim/" + number);
            }
        } else {
            Msg msg = new Msg();
            msg.setMsg("실패!");
            msg.setObj(null);

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        MoimDto moimDto = moimService.add(dto);
        System.out.println("MoimDto 값");
        System.out.println(moimDto.toString());

        return new ResponseEntity<>(new Msg(), HttpStatus.OK);
    }
}
