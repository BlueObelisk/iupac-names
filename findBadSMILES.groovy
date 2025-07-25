@Grab(group='io.github.egonw.bacting', module='managers-cdk', version='1.0.4')
@Grab(group='io.github.egonw.bacting', module='managers-rdf', version='1.0.4')
@Grab(group='io.github.egonw.bacting', module='managers-ui', version='1.0.4')
@Grab(group='io.github.egonw.bacting', module='managers-pubchem', version='1.0.4')
@Grab(group='io.github.egonw.bacting', module='managers-inchi', version='1.0.4')
@Grab(group='io.github.egonw.bacting', module='managers-opsin', version='1.0.4')

import groovy.cli.commons.CliBuilder

workspaceRoot = ".."
ui = new net.bioclipse.managers.UIManager(workspaceRoot);
cdk = new net.bioclipse.managers.CDKManager(workspaceRoot);
bioclipse = new net.bioclipse.managers.BioclipseManager(workspaceRoot);
inchi = new net.bioclipse.managers.InChIManager(workspaceRoot);
rdf = new net.bioclipse.managers.RDFManager(workspaceRoot);
pubchem = new net.bioclipse.managers.PubChemManager(workspaceRoot);
opsin = new net.bioclipse.managers.OpsinManager(workspaceRoot);

new File("iupac-names.txt").eachLine { name ->
  smiles = opsin.parseIUPACNameAsSMILES(name)
  println name + " -> " + smiles
  try {
    mol = cdk.fromSMILES(smiles)
  } catch (Exception e) {
    println e.message
  }
}
