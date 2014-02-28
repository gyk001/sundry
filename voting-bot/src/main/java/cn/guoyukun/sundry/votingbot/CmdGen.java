package cn.guoyukun.sundry.votingbot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CmdGen {

	public static void main(String[] args) {
		Random r = new Random(System.currentTimeMillis());
		
		String[] ipPrefixs = new String[]{
				"120.15.255.255",
				"110.255.255.255",
				"27.191.255.255",
				"60.7.255.255",
				"106.119.255.255",
				"121.23.255.255",
				"111.227.255.255",
				"119.251.255.255",
				"121.27.255.255",
				"123.183.255.255",
				"124.239.255.255",
				"110.231.255.255",
				"27.129.255.255",
				"121.29.255.255",
				"221.193.255.255",
				"106.9.255.255",
				"60.9.255.255",
				"222.223.255.255",
				"218.12.255.255",
				"218.11.255.255",
				"219.148.255.255",
				"221.194.255.255",
				"221.195.255.255",
				"182.51.255.255",
				"60.10.255.255",
				"61.55.255.255",
				"61.182.255.255",
				"61.134.191.255",
				"61.159.63.255",
				"202.99.159.255",
				"202.99.191.255",
				"202.99.175.255",
				"202.99.167.255",
				"103.22.87.255",
				"103.3.159.255",
				"103.1.171.255"
		};
		
		
		List<String> cmds = new ArrayList<String>();
		for(String prefix: ipPrefixs){
			String[] nums = prefix.split("\\.");
			int count = r.nextInt(80);
			for(int i=0; i< count; i++){
				StringBuilder ip = new StringBuilder();
				for(String num :nums){
					if("255".equals(num)){
						ip.append(r.nextInt(255)).append(".");
					}else{
						ip.append(num).append(".");
					}
				}
				ip.deleteCharAt(ip.length()-1);
				//String cmd = "curl --header \"X-Forwarded-For: "+ip.toString()+"\" http://fcbz.nongmintv.com/digg.php\\?id\\=37254\\&mod\\=23\\&catid\\=1809";
				String cmd = "curl --header \"X-Forwarded-For: "+ip.toString()+"\" http://fcbz.nongmintv.com/show.php\\?itemid\\=37254";
				cmds.add(cmd);
			}
		}
		Collections.shuffle(cmds);
		System.out.println("# "+cmds.size());
		for(String cmd: cmds){
			
			System.out.println(cmd);
		}
		
	}

}
