package com.cssl.serviceImpl;

import com.cssl.dao.SubjectDao;
import com.cssl.pojo.Options;
import com.cssl.pojo.Piao;
import com.cssl.pojo.Show;
import com.cssl.pojo.Subject;
import com.cssl.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService{
    @Autowired
    private SubjectDao sdao;//持有投票主题的引用

    @Override
    public List<Show> selectAll(String title) {//查询主页显示内容
        return sdao.selectAll(title);
    }

    @Override
    public List<Show> tjselectAll(int sid) {//点击主题显示详细内容
        return sdao.tjselectAll(sid);
    }

    @Override
    public List<Piao> piaoSelect(int sid) {///查询点击主题详细内容的票数
        return sdao.piaoSelect(sid);
    }

    @Override
    public int sumPiao(int sid) {//查询总票数
        return sdao.sumPiao(sid);
    }

    @Override
    public int insertTitle(Subject subject) {//新增新闻主题和新闻类型
        return sdao.insertTitle(subject);
    }

    @Override
    public int insertContent(Subject subject) {//新增新闻主题选项
        return sdao.insertContent(subject);
    }

    @Override
    public int chaPiao(int uid) {
        return sdao.chaPiao(uid);
    }

    @Override
    public int touPiao(int uid, int sid, int oid) {
        return sdao.touPiao(uid, sid, oid);
    }

    @Override
    public int updateZT(int uid) {
        return sdao.updateZT(uid);
    }

    @Override
    public int updateXX(int uid, int type) {
        return sdao.updateXX(uid, type);
    }

    @Override
    public int selectPdTitle(String s) {
        return sdao.selectPdTitle(s);
    }

    @Override
    public int updateTitle(String content, int oid) {
        return sdao.updateTitle(content, oid);
    }

    @Override
    public int deleteTitle(int oid) {
        return sdao.deleteTitle(oid);
    }

    @Override
    public int insertXuanXiang(Options options) {
        return sdao.insertXuanXiang(options);
    }
}
