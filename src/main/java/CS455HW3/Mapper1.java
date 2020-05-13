package CS455HW3;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapred.*;

public class Mapper1 extends Mapper<LongWritable, Text, Text, IntWritable>{
	
	public static enum COUNTER{
		INVALID_RECORD_COUNT;
	}

	
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
		String line = value.toString();
		String[] delimittedLine = line.split(",");
		if(delimittedLine.length >= 3) {
//			String state = delimittedLine[0].replace("\"","");
			String site = delimittedLine[0].replace("\"","") + delimittedLine[1].replace("\"","") + delimittedLine[2].replace("\"","");
//			System.out.println("state: " + state + " site: " + site);
			context.write(new Text(site), new IntWritable(1));
		}
		else {
			context.getCounter(COUNTER.INVALID_RECORD_COUNT).increment(1);
		}

	}
	
}
