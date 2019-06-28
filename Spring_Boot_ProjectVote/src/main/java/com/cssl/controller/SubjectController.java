package com.cssl.controller;

import com.cssl.pojo.Options;
import com.cssl.pojo.Piao;
import com.cssl.pojo.Show;
import com.cssl.pojo.Subject;
import com.cssl.serviceImpl.SubjectServiceImpl;
import com.cssl.vo.OptionsVo;
import com.cssl.vo.SubjectVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;

@Controller
public class SubjectController {//投票主题显示控制器
    @Autowired
    private SubjectServiceImpl ssl;//持有投票主题业务逻辑层引用

    @GetMapping("jiazai")
    public String jiazai(Model model, String pageIndex, HttpServletRequest request){//投票主题主页加载
        if(pageIndex==null){
            pageIndex="1";
        }
        Page<Show> pg= PageHelper.startPage(Integer.valueOf(pageIndex),3);
        String title=request.getParameter("keywords");
        //System.out.print("模糊查询"+title);
        List<Show> list= ssl.selectAll(title);//查询全部信息
        model.addAttribute("list",list);//将查询到的信息存放到model中
        return "votelist";
    }

    @GetMapping("xiangxi/{sid}")
    public String xiangxi(@PathVariable String sid,Model model){//点击主题显示详细内容
        //System.out.print("------数据"+sid);
        Piao p=new Piao();
        p.setSize(ssl.sumPiao(Integer.valueOf(sid)));
        //System.out.print("总票数"+p.getSize());
        List<Show> list=ssl.tjselectAll(Integer.valueOf(sid));//查询对应主题详细内容
        List<Piao> piaolist=ssl.piaoSelect(Integer.valueOf(sid));//查询点击主题详细内容的票数
        model.addAttribute("list",list);//将查询到的信息存放到model中
        model.addAttribute("piao",piaolist);
        model.addAttribute("sum",p);
        return "voteview";
    }

    @GetMapping("inertTitle")
    public String insertTitle(SubjectVo svo,HttpServletRequest request){//新增新闻主题和新闻类型和选项
        Subject sub=new Subject();
        BeanUtils.copyProperties(svo, sub);
        String[] content = request.getParameterValues("content");
        if(ssl.insertTitle(sub)>0){
        for (String s : content) {
            //System.out.print("选项名称:"+s);
            sub.setContent(s);
            ssl.insertContent(sub);
            }
            return "forward:jiazai";
        }else{
            return "login";
        }
    }

    @GetMapping("canyu/{sid}")
    public String canYu(@PathVariable String sid,Model model){//参与投票
        List<Show> list=ssl.tjselectAll(Integer.valueOf(sid));//查询对应主题详细内容
        List<Piao> piaolist=ssl.piaoSelect(Integer.valueOf(sid));//查询点击主题详细内容的票数
        model.addAttribute("list",list);//将查询到的信息存放到model中
        model.addAttribute("piao",piaolist);
        return "vote";
    }

    @PostMapping("/toupiao1")
    public String canYuTouPiao(String uid,String sid,String oid,HttpServletRequest request){//参与投票
        //System.out.print("用户id:"+uid);
        //int uuu=ssl.chaPiao(Integer.valueOf(uid));
        //System.out.print("有没有投票:"+uuu+"呢");
        oid=request.getParameter("xuanxiang");
        //System.out.print("主题id："+sid+"啊");
        //System.out.print("选项id："+oid+"啊");
        if(ssl.chaPiao(Integer.valueOf(uid))!=0){//如果用户投过了就不能投了
            return "login";
        }else{//用户如果没投票的话就可以投票
            if(ssl.touPiao(Integer.valueOf(uid),Integer.valueOf(sid),Integer.valueOf(oid))>0){//投票成功
                ssl.updateZT(Integer.valueOf(uid));//修改用户的投票状态
                return "redirect:/jiazai";
            }else {
                return "vote";
            }
        }
    }

    @GetMapping("weihujiazai")
    public String weihuJiaZai(String title,Model model){//查询所有维护的主题
        List<Show> list= ssl.selectAll(title);//查询全部信息
        model.addAttribute("list",list);//将查询到的信息存放到model中
        return "weihu";
    }

    @GetMapping("qrWeiHu/{sid}")
    public String qrWeiHu(@PathVariable String sid,Model model){//查询维护详细主题
        List<Show> list=ssl.tjselectAll(Integer.valueOf(sid));//查询对应主题详细内容
        List<Piao> piaolist=ssl.piaoSelect(Integer.valueOf(sid));//查询点击主题详细内容的票数
        model.addAttribute("list",list);//将查询到的信息存放到model中
        model.addAttribute("piao",piaolist);
        return "qrweihu";
    }

    @PostMapping("weihuPg/{sid}")
    public String weihu(@PathVariable String sid,HttpServletRequest request){
        String type=request.getParameter("type");
        //System.out.print("选项类型:"+type+"啊");
        //System.out.print("------数据"+sid);
        if(type!=null){
            //修改投票类型
            ssl.updateXX(Integer.valueOf(sid),Integer.valueOf(type));

            String[] content = request.getParameterValues("content");//获取选项名
            String[] oid = request.getParameterValues("oid");//获取选项编号
            //新增
            if(content.length>oid.length){
                for(int i=oid.length;i<content.length;i++){
                    Options options=new Options();
                    options.setContent(content[i]);
                    options.setOsid(Integer.valueOf(sid));
                    ssl.insertXuanXiang(options);
                    return "redirect:/jiazai";
                }
            }else {
                for (String s : content) {
                    for (String o : oid) {
                        //System.out.print("选项编号:"+o);
                        if(ssl.selectPdTitle(s)<=0){//修改
                            //System.out.print("进来了");
                            ssl.updateTitle(s,Integer.valueOf(o));
                            return "redirect:/jiazai";
                        }
                   /* else if(s==null){//删除
                        ssl.deleteTitle(Integer.valueOf(o));//删除选项
                    }*/
                    }
                    //System.out.print("选项名称:"+s);
                }
            }

            return "redirect:/jiazai";
        }
        return "redirect:/jiazai";
    }


    @RequestMapping("shanchu/{oid}")
    public String shanchu(@PathVariable String oid){
        ssl.deleteTitle(Integer.valueOf(oid));//删除选项
        return "redirect:/jiazai";
    }
}
