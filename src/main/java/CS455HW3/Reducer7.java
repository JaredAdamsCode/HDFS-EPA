package CS455HW3;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Reducer7 extends Reducer<Text, LongWritable, Text, LongWritable>{

	protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
		Long count = (long) 0;
        for(LongWritable val : values){

        	count += val.get();
        }
        context.write(key, new LongWritable(count));
	}
}
