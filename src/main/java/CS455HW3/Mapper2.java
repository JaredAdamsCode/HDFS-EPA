package CS455HW3;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapred.*;

import java.io.IOException;


public class Mapper2 extends Mapper<LongWritable, Text, Text, IntWritable>{
	
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		
		String line = value.toString();
		if(line.length() >= 2) {
			String state = line.substring(0, 2);
			context.write(new Text(state), new IntWritable(1));
		}
		
	}
	

}
