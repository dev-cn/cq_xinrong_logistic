package cq.anbu.modules.sys.entity;


import java.io.Serializable;
import java.util.List;

/**
 * 菜单管理
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:26:39
 */
public class SysMenuEntity extends SysMenuUpdateEntity implements Serializable {
    private List<?> list;

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}
