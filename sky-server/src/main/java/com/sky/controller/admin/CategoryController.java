package com.sky.controller.admin;


import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("分类模块管理")
@RequestMapping("/admin/category")
@RestController
@Slf4j
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 新增分类
     * 注意加@RequestBody来传输数据
     * @param categoryDTO
     * @return
     */
    @PostMapping
    @ApiOperation("新增分类")
    public Result<String> save(@RequestBody CategoryDTO categoryDTO) {
        log.info("新增员工：{}", categoryDTO);
        categoryService.save(categoryDTO);
        return Result.success();
    }

    /**
     *修改分类
     * @param categoryDTO
     * @return
     */
    @PutMapping()
    @ApiOperation("修改分类")
    public Result<String> update(@RequestBody CategoryDTO categoryDTO) {
        categoryService.update(categoryDTO);
        return Result.success();
    }

    /**
     * 分页查询
     * @param employeePageQueryDTO
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("分页查询")
    public Result<PageResult> page(CategoryPageQueryDTO employeePageQueryDTO) {
        log.info("分页查询:{}", employeePageQueryDTO);
        PageResult pageResult=categoryService.pageQuery(employeePageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     *根据id删除分类
     * @param id
     * @return
     */
    @DeleteMapping
    @ApiOperation("根据id删除分类")
    public Result<String> deleteById(Long id) {
        categoryService.deleteById(id);
        return Result.success();
    }

    /**
     * 根据类型查询分类/?
     * @param type
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("根据类型查询分类")
    public Result<List<Category>> list(Integer type) {
        List<Category> list=categoryService.list(type);
        return Result.success(list);
    }

    /**
     * 启用，禁用分类
     * @param status
     * @param id
     * @return
     */
    @PostMapping("/status/{status}")
    @ApiOperation("启用，禁用分类")
    public Result<String> startOrStop(@PathVariable Integer status,Long id){
        categoryService.startOrStop(status,id);
        return Result.success();
    }


}
