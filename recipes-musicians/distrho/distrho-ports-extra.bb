SUMMARY = "Collection of synthesizers and plugins"
HOMEPAGE = "http://distrho.sourceforge.net/ports"
LICENSE = "GPLv2 & MIT"
LIC_FILES_CHKSUM = " \
    file://ports/argotlunar/README.md;md5=81abc323be6ba481ab72864b53b3daca \
    file://ports/protoplug/license.txt;md5=56b9d913eb7c3ef00ca375ab614bf02f \
"

SRC_URI = " \
    git://github.com/DISTRHO/DISTRHO-Ports-Extra.git \
"
# TODO:
# argolunar: no sound (presets?)
# pdpulp: segfault
# protoplug asks for files

SRCREV = "b6f25f1feb4de49136844f20d88bec6439cdfbc5"
S = "${WORKDIR}/git"
PV = "0.0.0+git${SRCPV}"

REQUIRED_DISTRO_FEATURES = "x11 opengl"

inherit lv2-turtle-helper distro_features_check pack_audio_plugins

# distro-ports dependency for special hack script / libs 
DEPENDS += " \
    premake3-native \
    virtual/libgl \
    libx11 \
    libxext \
    libxcursor \
    freetype \
    csound \
    distrho-ports \
"

LV2_TTL_GENERATOR = "${STAGING_BINDIR}/lv2_ttl_generator"

do_ttl_sed() {
    # Seems this collection is not ready for public
    # scripts/libs are (broken) symlinks to /usr/src/distrho) - copy 'shared'
    # from distrho-ports (hack but we need to patch distrho-ports only)
    rm -f ${S}/libs
    rm -f ${S}/scripts
    mkdir ${S}/scripts
    cp  -r ${STAGING_BINDIR}/scripts/* ${S}/scripts
    # manipulate scripts to keep lv2_ttl_generator-calls in script for lv2-turtle-helper
    sed -i 's|$GEN ./$FILE|echo "`pwd`/$FILE" >> ${LV2_PLUGIN_INFO_FILE}|g' `find ${S}/scripts -name *.sh`
}

do_configure() {
    # platforms supporting sse2 can override NOOPTIMIZATIONS - later todo?
    NOOPTIMIZATIONS=1 ${S}/scripts/premake-update.sh linux
}

do_install() {
    install -d ${D}${libdir}
	cp -r ${S}/bin/* ${D}${libdir}
}

FILES_${PN} += " \
    ${libdir}/cabbage* \
"

# for common (?) cabbage files
RDEPENDS_${PN_LV2} += "${PN}"
RDEPENDS_${PN_VST} += "${PN}"

# Have not found what causes stripping - debugging of plugins is unlikely
INSANE_SKIP_${PN} = "already-stripped"
