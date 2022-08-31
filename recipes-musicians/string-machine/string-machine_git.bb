SUMMARY = "A virtual-analog string ensemble synthesize"
HOMEPAGE = "https://github.com/jpcima/string-machine"
LICENSE = "BSL-1.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e4224ccaecb14d942c71d31bef20d78c"

DEPENDS += " \
    virtual/libx11 \
    virtual/libgl \
    cairo \
"

inherit pkgconfig features_check lv2-turtle-helper pack_audio_plugins

REQUIRED_DISTRO_FEATURES = "x11"

SRC_URI = " \
    gitsm://github.com/jpcima/string-machine.git;branch=master;protocol=https \
"
SRCREV = "7050cb1516fbaf5aaaa2c6cc9999fe5ac100d746"
S = "${WORKDIR}/git"
PV = "0.1.1+git${SRCPV}"

EXTRA_OEMAKE += " \
    PREFIX=${prefix} \
    NOOPT=true \
    SKIP_STRIPPING=true \
"

do_ttl_sed() {
    sed -i 's|${EXE_WRAPPER} "${GEN}" "./\x24{FILE}"|echo "`realpath  "./$FILE"`" >> ${LV2_PLUGIN_INFO_FILE}|g' ${S}/dpf/utils/generate-ttl.sh
}

do_install() {
    oe_runmake DESTDIR=${D} PREFIX=${prefix} LIBDIR=${libdir} install
}
