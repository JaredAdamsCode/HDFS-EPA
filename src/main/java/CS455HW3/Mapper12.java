package CS455HW3;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapred.*;

public class Mapper12 extends Mapper<LongWritable, Text, Text, IntWritable>{
	

	
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
		String line = value.toString();
		String[] delimittedLine = line.split(",");
		if(delimittedLine.length > 0) {
			String unit = delimittedLine[14].substring(0, 14).replace("\"","");
//			String site = delimittedLine[0].replace("\"","") + delimittedLine[1].replace("\"","") + delimittedLine[2].replace("\"","");
//			System.out.println("state: " + state + " site: " + site);
			context.write(new Text(unit), new IntWritable(1));
		}
//		else {
//			context.getCounter(COUNTER.INVALID_RECORD_COUNT).increment(1);
//		}

	}
	
}
