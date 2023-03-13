package com.zxq.dao;

import com.github.pagehelper.Page;
import com.zxq.entity.PageResult;
import com.zxq.entity.QueryPageBean;
import com.zxq.pojo.CheckGroup;
import com.zxq.pojo.Setmeal;

import java.util.List;
import java.util.Map;

public interface SetmealDao {
    public void add(Setmeal setmeal);
    public void setSetmealAndCheckGroup(Map map);
    public Page<CheckGroup> findByCondition(String queryString);
    public List<Setmeal> findAll();
    public Setmeal findById(int id);
}
