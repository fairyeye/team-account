//package com.li.ta.common;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
///**
// * @author huapeng.zhang
// * @version 1.0.0
// * @createTime 2020年12月07日 17:35:00
// */
//@Component
//public class DownloadFile {
//    @Autowired
//    private RestTemplate restTemplate;
//
//    public void down() {
////            URL url = new URL("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1607343502808&di=0d1d7d5e281e18d82cb12a9a1acc9f0f&imgtype=0&src=http%3A%2F%2Fc-ssl.duitang.com%2Fuploads%2Fitem%2F202006%2F21%2F20200621151319_vmoze.thumb.400_0.jpeg");
//        ResponseEntity<byte[]> responseEntity = restTemplate.getForEntity("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1607343502808&di=0d1d7d5e281e18d82cb12a9a1acc9f0f&imgtype=0&src=http%3A%2F%2Fc-ssl.duitang.com%2Fuploads%2Fitem%2F202006%2F21%2F20200621151319_vmoze.thumb.400_0.jpeg", byte[].class);
//                byte[] bytes = responseEntity.getBody();
//    }
//}
