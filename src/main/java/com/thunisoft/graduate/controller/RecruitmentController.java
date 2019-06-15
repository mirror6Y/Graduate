package com.thunisoft.graduate.controller;

import com.github.pagehelper.PageInfo;
import com.thunisoft.graduate.common.Constants;
import com.thunisoft.graduate.common.model.Recruitment;
import com.thunisoft.graduate.service.IRecruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @auther mirror6
 * @date 2019/6/11 20:31
 */
@RestController
@RequestMapping("/recruitment")
public class RecruitmentController {

    private final IRecruitmentService recruitmentService;

    @Autowired
    public RecruitmentController(IRecruitmentService recruitmentService) {
        this.recruitmentService = recruitmentService;
    }

    /**
     * 添加招聘信息
     * url:"http://localhost:8088/unit/addUnit"
     */
    @ResponseBody
    @PostMapping("/addRecruitment")
    public String Recruitment(Recruitment recruitment) {
        recruitmentService.addRecruitment(recruitment);
        return Constants.C_SUCCESS;
    }

    @DeleteMapping("/deleteRecruitmentById/{id}")
    public String deleteGraduateById(@PathVariable("id") String id) {
        recruitmentService.deleteRecruitmentById(id);
        return Constants.C_SUCCESS;
    }


    @PutMapping("/updateRecruitment")
    public String updateGraduate(Recruitment recruitment) {
        recruitmentService.updateRecruitment(recruitment);
        return Constants.C_SUCCESS;
    }

    @GetMapping("/getRecruitmentById/{id}/{operation}")
    public ModelAndView getRecruitmentById(Model model, @PathVariable("id") String id, @PathVariable("operation") String operation) {
        int presence = recruitmentService.getRecruitmentsCountById(id);
        if (presence > 0)
        {
            Recruitment recruitment = recruitmentService.getRecruitmentById(id);
            model.addAttribute("recruitmentInfo", recruitment);
            if ("update".equals(operation))
            {
                return new ModelAndView("recruitment/recruitmentUpdate");
            } else if ("delete".equals(operation))
            {
                return new ModelAndView("recruitment/recruitmentDelete");
            } else
            {
                return new ModelAndView("recruitment/recruitmentInfo");
            }
        } else
        {
            return new ModelAndView("error");
        }
    }

    @GetMapping("/getRecruitments")
    public ModelAndView getGraduates(Model model, @RequestParam(defaultValue = "5") Integer pageSize, @RequestParam(defaultValue = "1") Integer pageNum, Recruitment recruitment) {
        PageInfo<Recruitment> pageInfo = recruitmentService.getRecruitments(pageSize, pageNum);
        model.addAttribute("pageInfo", pageInfo);
        //获得当前页
        model.addAttribute("pageNum", pageInfo.getPageNum());
        //获得一页显示的条数
        model.addAttribute("pageSize", pageInfo.getPageSize());
        //是否是第一页
        model.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
        //获得总页数
        model.addAttribute("totalPages", pageInfo.getPages());
        //是否是最后一页
        model.addAttribute("isLastPage", pageInfo.isIsLastPage());
        return new ModelAndView("index/index");
    }
}
