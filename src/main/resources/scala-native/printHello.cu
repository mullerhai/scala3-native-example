// #include "meapi.h"
// __global__ void helloKernel(int numElements)
// {
//
// 	int i = blockDim.x * blockIdx.x + threadIdx.x;
//
// 	if (i < numElements)
// 	{
// 		printf("%d: Hello, CUDA!\n ", i);
// 	}
//
// }
//
// void printHello(int numPrint)
// {
// 	int threadsPerBlock = 256;
// 	int blocksPerGrid = (numPrint + threadsPerBlock - 1) / threadsPerBlock;
// 	helloKernel << <threadsPerBlock, blocksPerGrid >> > (numPrint);
// 	cudaDeviceSynchronize();
// }