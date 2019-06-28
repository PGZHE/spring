package com.cssl.dao;

import com.cssl.pojo.Options;
import com.cssl.pojo.Piao;
import com.cssl.pojo.Show;
import com.cssl.pojo.Subject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SubjectDao {
    public List<Show> selectAll(@Param("title") String title);//查询主页显示的内容(模糊查询主题)

    public List<Show> tjselectAll(int sid);//点击主题显示详细内容

    public List<Piao> piaoSelect(@Param("sid") int sid);//查询点击主题详细内容的票数

    public int sumPiao(@Param("sid") int sid);//查询总票数

    public int insertTitle(Subject subject);//新增新闻主题和新闻类型

    public int insertContent(Subject subject);//新增新闻主题选项

    public int chaPiao(@Param("uid") int uid);//查询是否投票

    public int touPiao(@Param("uid") int uid,@Param("sid") int sid,@Param("oid") int oid);

    public int updateZT(@Param("uid") int uid);//修改用户投票状态

    public int updateXX(@Param("sid") int uid ,@Param("type") int type);//修改选项类型

    public int selectPdTitle(@Param("s") String s);//查询对应的主题

    public int updateTitle(@Param("content") String content,@Param("oid") int oid);//修改选项名

    public int deleteTitle(@Param("oid") int oid);//删除选项

    public int insertXuanXiang(Options options);//新增选项
}
