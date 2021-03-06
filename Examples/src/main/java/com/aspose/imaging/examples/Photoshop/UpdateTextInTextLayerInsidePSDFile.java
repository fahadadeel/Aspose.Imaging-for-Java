package com.aspose.imaging.examples.Photoshop;

import com.aspose.imaging.Color;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.psd.CompressionMethod;
import com.aspose.imaging.fileformats.psd.layers.Layer;

public class UpdateTextInTextLayerInsidePSDFile {
	public static void main(String... args) throws Exception {
		String dataDir = Utils.getSharedDataDir(UpdateTextInTextLayerInsidePSDFile.class) + "Photoshop/";
		String sourceFileName = dataDir + "samplePsd.psd";
		String outputFile = dataDir + "UpdateTextInTextLayerInsidePSDFile_out.psd";

		// Load an existing PSD file as Image
		com.aspose.imaging.Image image = com.aspose.imaging.Image.load(sourceFileName);
		try {
			// Convert Image to PsdImage.
			com.aspose.imaging.fileformats.psd.PsdImage psdImage = (com.aspose.imaging.fileformats.psd.PsdImage) image;

			// Get all layers inside PSD file.
			Layer[] arrLayers = psdImage.getLayers();

			// Count total number of layers and iterate through each layer.
			int layers = arrLayers.length;
			for (int i = 0; i < layers; i++) {
				// Check if layer is a text layer.
				if (arrLayers[i] instanceof com.aspose.imaging.fileformats.psd.layers.TextLayer) {
					// Convert the layer to TextLayer.
					com.aspose.imaging.fileformats.psd.layers.TextLayer textLayer1 = (com.aspose.imaging.fileformats.psd.layers.TextLayer) arrLayers[i];

					// Update the text in text layer.
					textLayer1.updateText("IK Changed TEXT");

					// Update the text with new font size and new text color in
					// text layer.
					textLayer1.updateText("New a", 48.0f, Color.getBlack());
				}
			}

			// Create an instance of PsdOptions class.
			com.aspose.imaging.imageoptions.PsdOptions psdOpt = new com.aspose.imaging.imageoptions.PsdOptions();

			// Call setCompressionMethod method.
			psdOpt.setCompressionMethod(CompressionMethod.RLE);

			// Save the updated PSD file.
			psdImage.save(outputFile, psdOpt);

		} finally {
			image.dispose();
		}
	}
}
