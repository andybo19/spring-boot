package com.example.demo.service.hash;

import java.util.LinkedList;
import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHashVirtualNode {
    //待添加入Hash环的服务器列表
    private static String[] servers={"192.168.0.0:111", "192.168.0.1:111", "192.168.0.2:111","192.168.0.3:111", "192.168.0.4:111"};

    //真实节点
    private static LinkedList<String> realNodes = new LinkedList<>();

    //每个节点的虚拟节点数
    private static Integer NODE_VALUES=5;

    /**
     * key 表示服务的hash值,value表示服务器的名称
     */
    private static SortedMap<Integer,String> serverMap = new TreeMap<>();


    /**
     * 程序初始化,将服务地址加入hash环
     */
    static {
        for(int i=0;i<servers.length;i++){
            realNodes.add(servers[i]);
        }
        for (String str : realNodes) {
            for (int i=0;i<NODE_VALUES;i++){
                String virtualName = str +"&&VN"+String.valueOf(i);
                int hash = getHash(virtualName);
                System.out.println("虚拟节点[" + virtualName + "]被添加, hash值为" + hash);
                serverMap.put(hash,virtualName);
            }
        }
    }

    /**
     * 计算hash值
     * @param str
     * @return
     */
    private static Integer getHash(String str){
        final int p = 16777619;
        int hash = (int)2166136261L;
        for (int i = 0; i < str.length(); i++){
            hash = (hash ^ str.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        // 如果算出来的值为负数则取其绝对值
        if (hash < 0){
            hash = Math.abs(hash);
        }
        return hash;
    }

    /**
     * 得到对应的路由服务器
     * @param node
     * @return
     */
    private static String getServer(String node){
        int hash = getHash(node);
        if(hash > serverMap.lastKey()){
            String virtualNode = serverMap.get(serverMap.firstKey());
            return virtualNode.substring(0,virtualNode.indexOf("&&"));
        }
        SortedMap<Integer, String> subMap = serverMap.tailMap(hash);
        Integer i = subMap.firstKey();
        String virtualNode = serverMap.get(i);
        return virtualNode.substring(0,virtualNode.indexOf("&&"));
    }

    public static void main(String[] args) {
        System.out.println(serverMap.firstKey());
        System.out.println(serverMap.lastKey());
        String nodes[] = {"127.0.0.1:1111", "221.226.0.1:2222", "10.211.0.1:3333"};
        for (int i=0;i<nodes.length;i++){
            System.out.println("[" + nodes[i] + "]的hash值为" +
                    getHash(nodes[i]) + ", 被路由到结点[" + getServer(nodes[i]) + "路由结点的hash值为"+getHash(getServer(nodes[i]))+"]");
        }
    }

}
