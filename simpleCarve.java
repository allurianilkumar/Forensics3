import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.File;
import java.io.BufferedOutputStream;


public class simpleCarve{
	public static OutputStream ooStreamObj;
	void pngInputFile(InputStream iiStreamObj,String file)throws Exception{
		boolean success=false;
		int imageFrmts,imageFrmts2 = 0,imageFrmts3 = 0,imageFrmts4 = 0,imageFrmts5 = 0,imageFrmts6 = 0,imageFrmts7 = 0,imageFrmts8 = 0;
		OutputStream ooStreamObj = null;
		do{	
			File outputFile = new File(new File(System.getProperty("user.dir")),file );
			if (outputFile.exists()){
				ooStreamObj = new BufferedOutputStream(new FileOutputStream(outputFile)); 
			}else {
				ooStreamObj = new BufferedOutputStream(new FileOutputStream(outputFile));
			}
		}while (ooStreamObj == null);
	    do{
	        imageFrmts = iiStreamObj.read();
	        if (imageFrmts == 0x89){
	            imageFrmts2 = iiStreamObj.read();
	            if (imageFrmts2 == 0x50){
	                imageFrmts3 = iiStreamObj.read();
	                if (imageFrmts3 == 0x4E){
	                	imageFrmts4 = iiStreamObj.read();
	                    if (imageFrmts4 == 0x47){
	                    	imageFrmts5 = iiStreamObj.read();
	                        if (imageFrmts5 == 0x0D){
	                        	imageFrmts6 = iiStreamObj.read();
	                            if (imageFrmts6 == 0x0A){
	                            	imageFrmts7 = iiStreamObj.read();
	                                if (imageFrmts7 == 0x1A){
	                                	imageFrmts8 = iiStreamObj.read();
	                                    if (imageFrmts8 == 0x0A){
	                                    	success=true;
	                                    }
	                                }
	                            }
	                        }
	                    }
	                }
	            }
	        }
	        if(success) {
	        	ooStreamObj.write(imageFrmts);
                ooStreamObj.write(imageFrmts2);
                ooStreamObj.write(imageFrmts3);
                ooStreamObj.write(imageFrmts4);
                ooStreamObj.write(imageFrmts5);
                ooStreamObj.write(imageFrmts6);
                ooStreamObj.write(imageFrmts7);
                ooStreamObj.write(imageFrmts8);
                PngOfOutputFile(iiStreamObj, ooStreamObj);
	        }
	    }while(imageFrmts != -1);
	}
	
	void PngOfOutputFile(InputStream iiStreamObj, OutputStream ooStreamObj)throws Exception {
	    boolean isSuccessing = true;
		    do{
		        int imageFrmts = iiStreamObj.read();
		        if (imageFrmts == 0x89) {
		            int imageFrmts2 = iiStreamObj.read();
		            if (imageFrmts2 < 0) {
		                ooStreamObj.write(0x82);
		                isSuccessing = false;
		            }else if (imageFrmts2 == 0x49){
		                ooStreamObj.write(0x49);
		                ooStreamObj.write(0x45);
		                ooStreamObj.write(0x4E);
		                ooStreamObj.write(0x44);
		                ooStreamObj.write(0xAE);
		                ooStreamObj.write(0x42);
		                ooStreamObj.write(0x60);
		                ooStreamObj.write(0x82);
		                isSuccessing = false;
		            }else{
		                ooStreamObj.write(0x89);
		                ooStreamObj.write(imageFrmts2);
		            }
		        }else {
		        	if (imageFrmts == -1) {
		        		isSuccessing = false;
			        }else{
			            ooStreamObj.write(imageFrmts);
			        }
		        }
	    }while (isSuccessing);
	}
	void gifOfOutputFile(InputStream iiStreamObj, OutputStream ooStreamObj)throws Exception{
        boolean isSuccessing = true;
        do{
            int imageFrmts = iiStreamObj.read();
            if (imageFrmts == 0x47){
                int imageFrmts2 = iiStreamObj.read();
                if (imageFrmts2 < 0) {
                    ooStreamObj.write(0x00);
                    isSuccessing = false;
                }else if (imageFrmts2 == 0x21){
                    ooStreamObj.write(0x21);
                    ooStreamObj.write(0x00);
                    ooStreamObj.write(0x00);
                    ooStreamObj.write(0x3B);
                    ooStreamObj.write(0x00);
                    isSuccessing = false;
                }else{
                    ooStreamObj.write(0x47);
                    ooStreamObj.write(imageFrmts2);
                }
            }else if (imageFrmts == -1) {
                isSuccessing = false;
            }else {
                ooStreamObj.write(imageFrmts);
            }
        }while (isSuccessing);
        ooStreamObj.close();
    }
	void jpegOfOutput(InputStream iiStreamObj, OutputStream ooStreamObj){
		try {
		boolean isSuccessing = true;
		do{
			int imageFrmts = iiStreamObj.read();
			if (imageFrmts == 0xff) {
				int imageFrmts2 = iiStreamObj.read();
				if (imageFrmts2 < 0) {
					ooStreamObj.write(0xff);
					isSuccessing = false;
				}else if (imageFrmts2 == 0xd9) {
					ooStreamObj.write(0xff);
					ooStreamObj.write(0xd9);
					isSuccessing = false;
				}else{
					ooStreamObj.write(0xff);
					ooStreamObj.write(imageFrmts2);
				}
			}else {
				if (imageFrmts == -1) {
					isSuccessing = false;
				}else {
					ooStreamObj.write(imageFrmts);
				}
			}
		}while (isSuccessing);
		ooStreamObj.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


	
	void gifInputFile(InputStream ooStreamObj,String file)throws Exception {
		boolean success=false;
		int a1,a2 = 0,a3=0,a4=0,a5=0,a6=0;
	    OutputStream resultStream = null;
		do{	
			File dir= new File(System.getProperty("user.dir"));
			File outputFile = new File(dir, file);
			if (!outputFile.exists()){
				resultStream = new BufferedOutputStream(new FileOutputStream(outputFile));
			}else {
				resultStream = new BufferedOutputStream(new FileOutputStream(outputFile));
			}
		}while (resultStream == null);
	    do {
	        a1 = ooStreamObj.read();
	        if(a1 == 0x47) {
	            a2 = ooStreamObj.read();
	            if (a2 == 0x49) {
	                a3 = ooStreamObj.read();
	                if (a3 == 0x46) {
	                    a4 = ooStreamObj.read();
	                    if (a4 == 0x38) {
	                    	a5 = ooStreamObj.read();
	                        if (a5 == 0x39) {
	                        	a6 = ooStreamObj.read();
	                            if (a6 == 0x61) {
	                                success=true;
	                            }
	                        }
	                    }
	                }
	            }
	        }
	    }while (a1 != -1);
	    if(success) {
	    	resultStream.write(a1);
	    	resultStream.write(a2);
	        resultStream.write(a3);
	        resultStream.write(a4);
	        resultStream.write(a5);
	        resultStream.write(a6);
	        gifOfOutputFile(ooStreamObj, resultStream);
	    }
	}
	void jpgInputFile(InputStream iiStreamObj,String file)throws Exception {
		OutputStream ooStreamObj = null;
		do{	
			File outputFile = new File(new File(System.getProperty("user.dir")),file );
			if (outputFile.exists()){
				ooStreamObj = new BufferedOutputStream(new FileOutputStream(outputFile)); 
			}else {
				ooStreamObj = new BufferedOutputStream(new FileOutputStream(outputFile));
			}
		}while (ooStreamObj == null);
			int imageFrmts;
			do{
				imageFrmts = iiStreamObj.read();
				if(imageFrmts == 0xff){
					int imageFrmts2 = iiStreamObj.read();
					if (imageFrmts2 == 0xd8){
						int imageFrmts3 = iiStreamObj.read();
						if (imageFrmts3 == 0xff){
							ooStreamObj.write(imageFrmts);
							ooStreamObj.write(imageFrmts2);
							ooStreamObj.write(imageFrmts3);
							jpegOfOutput(iiStreamObj, ooStreamObj);
						}
					}
				}
			}while (imageFrmts != -1);
	}
	public static void main(String[] arg)throws Exception {
		try{
			simpleCarve s=new simpleCarve();
			if(arg.length >0) {
				if(3 >= arg.length) {
					s.jpgInputFile(new BufferedInputStream(new FileInputStream(arg[0])),"file1.jpg");
					s.pngInputFile(new BufferedInputStream(new FileInputStream(arg[0])),"file2.png");
					s.gifInputFile(new BufferedInputStream(new FileInputStream(arg[0])),"file3.gif");
				}else{
					System.out.println("Input Files formate have more than 3");
				}
			}else {
				System.out.println("Not Enttered the input files.");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
