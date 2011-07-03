package org.conan.taobao;

import java.util.Date;
import java.util.List;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.domain.Item;
import com.taobao.api.domain.ItemSearch;
import com.taobao.api.domain.SellerCat;
import com.taobao.api.domain.Shop;
import com.taobao.api.domain.User;
import com.taobao.api.request.ItemGetRequest;
import com.taobao.api.request.ItemsGetRequest;
import com.taobao.api.request.ItemsSearchRequest;
import com.taobao.api.request.SellercatsListGetRequest;
import com.taobao.api.request.ShopGetRequest;
import com.taobao.api.request.TimeGetRequest;
import com.taobao.api.request.UserGetRequest;
import com.taobao.api.response.ItemGetResponse;
import com.taobao.api.response.ItemsGetResponse;
import com.taobao.api.response.ItemsSearchResponse;
import com.taobao.api.response.SellercatsListGetResponse;
import com.taobao.api.response.ShopGetResponse;
import com.taobao.api.response.TimeGetResponse;
import com.taobao.api.response.UserGetResponse;

/**
 * 
 * @author Conan Zhang
 * @email bsspirit@gmail.com
 * @date 2011-6-18
 */
public class TaoBao {

    private static TaobaoClient client = new DefaultTaobaoClient(MyConstant.URL_DEPLOY, MyConstant.KEY, MyConstant.SECRET);

    // private static TaobaoClient client = new DefaultTaobaoClient(AppConstant.URL_DEVELOP, AppConstant.KEY, AppConstant.SECRET_DEVELOP);

    /**
     * 商品API
     */
    public static Item getItem(long numIid) throws ApiException {
        ItemGetRequest req = new ItemGetRequest();
        req.setFields("detail_url,num_iid,title,nick,type,cid,seller_cids,props,input_pids,input_str,desc,pic_url,num,valid_thru,list_time,delist_time,stuff_status,location,price,post_fee,express_fee,ems_fee,has_discount,freight_payer,has_invoice,has_warranty,has_showcase,modified,increment,approve_status,postage_id,product_id,auction_point,property_alias,item_img,prop_img,sku,video,outer_id,is_virtual");
        req.setNumIid(numIid);
        ItemGetResponse res = client.execute(req, null);
        Item item = res.getItem();
        System.out.println("URL:" + item.getDetailUrl());
        return res.getItem();
    }

    /**
     * 商品API
     */
    public static Item getItem(String nick, long numIid) throws ApiException {
        ItemGetRequest req = new ItemGetRequest();
        req.setFields("detail_url,num_iid,title,nick,type,cid,seller_cids,props,input_pids,input_str,desc,pic_url,num,valid_thru,list_time,delist_time,stuff_status,location,price,post_fee,express_fee,ems_fee,has_discount,freight_payer,has_invoice,has_warranty,has_showcase,modified,increment,approve_status,postage_id,product_id,auction_point,property_alias,item_img,prop_img,sku,video,outer_id,is_virtual");
        req.setNick(nick);
        req.setNumIid(numIid);
        ItemGetResponse res = client.execute(req, null);
        Item item = res.getItem();
        System.out.println("URL:" + item.getDetailUrl());
        return res.getItem();
    }

    /**
     * 商品列表
     */
    public static List<Item> getItems(String nick) throws ApiException {
        ItemsGetRequest req = new ItemsGetRequest();
        req.setFields("detail_url,num_iid,title,nick,pic_url,cid,price,type,delist_time,post_fee,score,volume");
        req.setNicks(nick);
        ItemsGetResponse res = client.execute(req);
        return res.getItems();
    }

    /**
     * 商品列表
     */
    public static ItemsGetResponse getItems(String nick, long pageNo, long pageSize) throws ApiException {
        ItemsGetRequest req = new ItemsGetRequest();
        req.setFields("detail_url,num_iid,title,nick,pic_url,cid,price,type,delist_time,post_fee,score,volume");
        req.setNicks(nick);
        req.setPageNo(pageNo);
        req.setPageSize(pageSize);
        return client.execute(req);
    }

    /**
     * 商品列表
     */
    public static List<Item> getItems(String nick, String query) throws ApiException {
        ItemsGetRequest req = new ItemsGetRequest();
        req.setFields("num_iid,title,nick,pic_url,cid,price,type,delist_time,post_fee,score,volume");
        req.setNicks(nick);
        req.setQ(query);
        ItemsGetResponse res = client.execute(req);
        return res.getItems();
    }

    /**
     * 商品搜索
     */
    public static ItemSearch queryItems(String nick, String query) throws ApiException {
        ItemsSearchRequest req = new ItemsSearchRequest();
        req.setFields("detail_url,num_iid,title,nick,pic_url,cid,price,type,delist_time,post_fee,score,volume");
        req.setNicks(nick);
        req.setQ(query);
        ItemsSearchResponse res = client.execute(req);
        return res.getItemSearch();
    }

    /**
     * 用户API
     */
    public static User getUser(String nick) throws ApiException {
        UserGetRequest req = new UserGetRequest();
        req.setFields("user_id,uid,nick,sex,buyer_credit,seller_credit,location,created,last_visit,birthday,type,status,alipay_no,alipay_account,alipay_account,email,consumer_protection,alipay_bind");
        req.setNick(nick);
        UserGetResponse res = client.execute(req, null);
        return res.getUser();
    }

    /**
     * 店铺API
     */
    public static Shop getShop(String nick) throws ApiException {
        ShopGetRequest req = new ShopGetRequest();
        req.setFields("sid,cid,title,nick,desc,bulletin,pic_path,created,modified");
        req.setNick(nick);
        ShopGetResponse res = client.execute(req);
        return res.getShop();
    }

    /**
     * 卖家自定义产品分类API
     */
    public static List<SellerCat> getSellerCats(String nick) throws ApiException {
        SellercatsListGetRequest req = new SellercatsListGetRequest();
        req.setNick(nick);
        SellercatsListGetResponse res = client.execute(req);
        return res.getSellerCats();
    }

    /**
     * 淘宝服务器时钟API
     */
    public static Date getServerTime() throws ApiException {
        TimeGetRequest req = new TimeGetRequest();
        TimeGetResponse res = client.execute(req);
        return res.getTime();
    }

    public static void main(String[] args) throws ApiException {
        // getItem(MyConstant.USER, 10569620757l);
        // User u = getUser(MyConstant.USER);
        // System.out.println(u.getUserId());
        // System.out.println(u.getUid());
        // System.out.println(u.getNick());

//        List<Item> i0 = getItems(MyConstant.USER, 0, 10).getItems();
//        for (Item i : i0) {
//            System.out.println("i0:" + i.getTitle());
//        }
//
//        List<Item> i1 = getItems(MyConstant.USER, 1, 10).getItems();
//        for (Item i : i1) {
//            System.out.println("i1:" + i.getTitle());
//        }
//
//        List<Item> i2 = getItems(MyConstant.USER, 2, 10).getItems();
//        for (Item i : i2) {
//            System.out.println("i2:" + i.getTitle());
//        }
    }

}
