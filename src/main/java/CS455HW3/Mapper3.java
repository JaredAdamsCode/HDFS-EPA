package CS455HW3;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapred.*;

public class Mapper3 extends Mapper<LongWritable, Text, Text, IntWritable>{
	
	public static enum COUNTER{
		INVALID_RECORD_COUNT;
	}

	
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
		String line = value.toString();
		String[] delimittedLine = line.split(",");
		if(delimittedLine.length >= 3) {
			String unit = delimittedLine[13].replace("\"","");
			String state = delimittedLine[0].replace("\"","");
			if((state.equals("23") || state.equals("33") || state.equals("25") || state.equals("44") ||
					state.equals("09") || state.equals("36") || state.equals("34") || state.equals("10") ||
					state.equals("24") || state.equals("51") || state.equals("45") || state.equals("37") ||
					state.equals("13") || state.equals("12") || state.equals("42") || state.equals("11"))) {
				
				context.write(new Text(unit), new IntWritable(1));
				
			}
//			String site = delimittedLine[0].replace("\"","") + delimittedLine[1].replace("\"","") + delimittedLine[2].replace("\"","");
//			System.out.println("state: " + state + " site: " + site);
		}
		else {
			context.getCounter(COUNTER.INVALID_RECORD_COUNT).increment(1);
		}

	}
	
}
