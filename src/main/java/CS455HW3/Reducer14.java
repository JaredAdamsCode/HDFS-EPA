package CS455HW3;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Reducer14 extends Reducer<Text, DoubleWritable, Text, DoubleWritable>{

	protected void reduce(Text key, Iterable<DoubleWritable> values, Context context) throws IOException, InterruptedException {
		Long countEntries = (long) 0;
		Double sumValues = 0.0;
        for(DoubleWritable val : values){

        	countEntries += 1;
        	sumValues += val.get();
        }
        context.write(key, new DoubleWritable(sumValues/countEntries));
	}
}
