SUMMARY = "Commandline tools for soundfont analysis and split"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = " \
    file://LICENSE;md5=75859989545e37968a99b631ef42722e \
"
SRC_URI = "git://github.com/schnitzeltony/soundfont-cmdline-tools.git;branch=master;protocol=https"
SRCREV = "66b6cd4446abf616837718c62fa3f03bfb97afeb"
S = "${WORKDIR}/git"
PV = "0.0.0+git${SRCPV}"

BBCLASSEXTEND = "native"

do_compile() {
    oe_runmake
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/sf2-test ${D}${bindir}/
    install -m 0755 ${S}/sf2-split ${D}${bindir}/
}
