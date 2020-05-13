package CS455HW3;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Reducer1 extends Reducer<Text, IntWritable, Text, IntWritable>{

	protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
		int count = 0;
//		Set<String> valueSet = new HashSet<String>();
        for(IntWritable val : values){
//        	String temp = val.toString();
//        	System.out.println(key.toString() + " temp");
//            valueSet.add(temp);
        	count += val.get();
        }
//        int finalVal = valueSet.size();
//        System.out.println("finalVal is: " + finalVal);
        context.write(key, new IntWritable(count));
	}
}
