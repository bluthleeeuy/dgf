package WeightRandom;

import util.ServerWeightMapClass;

import java.util.*;

/**
 * Created by Jo on 12/9/16.
 */
public class WeightRandom {
	static Integer pos = 0;
	public static String testWeightRandom(){
		//通过新建方法内的局部变量serverMap,先将域变量复制到线程本地,以避免被多个线程修改.
		LinkedHashMap<String,Integer> serverWeightMap = ServerWeightMapClass.getMap();
		Map<String,Integer> serverMap = new LinkedHashMap<String, Integer>();
		serverMap.putAll(serverWeightMap);
		Set<String> keySet = serverMap.keySet();

		Iterator<String> it = keySet.iterator();
		List<String> serverList = new ArrayList<String>();

		while(it.hasNext()){
			String server = it.next();
			Integer weight = serverMap.get(server);
			for(int i = 0;i<weight;i++){
				serverList.add(server);
			}
		}
		Random random = new Random();
		int randomPos = random.nextInt(serverList.size());
		String server = serverList.get(randomPos);
		return server;
	}
}
