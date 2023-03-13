package com.zxq.service;

import com.zxq.entity.PageResult;
import com.zxq.entity.QueryPageBean;
import com.zxq.pojo.Setmeal;

import java.util.List;

public interface SetmealService {
    public void add(Setmeal setmeal, Integer[] checkgroupIds);
    public PageResult pageQuery(QueryPageBean queryPageBean);
    public List<Setmeal> findAll();
    public Setmeal findById(int id);
}
